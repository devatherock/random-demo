run:
	rm hello.alg
	zip hello.alg *.lua *.pongo2
	docker build -t devatherock/algernon-pongo:latest .
	docker run --rm -p 3000:3000 devatherock/algernon-pongo:latest