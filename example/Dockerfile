FROM alpine:3.18.5

RUN apk update \
		&& apk add --no-cache curl

ARG UPX_VERSION=3.96
ARG TARGETPLATFORM

RUN case ${TARGETPLATFORM:-linux/amd64} in \
        "linux/arm64")   UPX_ARCH="arm64" ;; \
        *)               UPX_ARCH="amd64" ;; \
    esac; \
    curl --location --output upx_linux.tar.xz "https://github.com/upx/upx/releases/download/v${UPX_VERSION}/upx-${UPX_VERSION}-${UPX_ARCH}_linux.tar.xz"; \
	tar -xJf upx_linux.tar.xz; \
	cp upx-${UPX_VERSION}-${UPX_ARCH}_linux/upx /bin/

ENTRYPOINT ["time", "dd", "if=/dev/urandom", "of=/dev/null", "bs=1024", "count=10000"]