FROM golang:1.18 as builder
LABEL MAINTAINER="devatherock@gmail.com"

ENV CGO_ENABLED=0
ENV GOOS=linux

# Install Algernon
RUN go install -trimpath -ldflags "-s" -a -v github.com/xyproto/algernon@a54d9ef87e1b161fe447ad04edc3b9172bcea625

# Copy in in the .alg file
COPY hello.alg hello.alg

# Start a new Dockerfile based on Alpine
FROM alpine:3.15.2
LABEL MAINTAINER="devatherock@gmail.com"
RUN apk add --no-cache ca-certificates

# Mount the configuration, cert and keys
#VOLUME /etc/algernon

# Copy in the .alg file
COPY hello.alg /srv/algernon/hello.alg

# Copy in the Algernon executable from the builder docker
COPY --from=builder /go/bin/algernon /usr/bin/algernon

# Expose port 80 (HTTP) and 443 (HTTPS)
EXPOSE 80 443

# Serve over HTTPS using the custom cert and key
CMD ["/usr/bin/algernon", "-c", "--cachesize", "67108864", "-n", "--dev", "--server", "/srv/algernon/hello.alg"]

