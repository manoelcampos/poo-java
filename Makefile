all: slides html pdf

install:
	#Install bundler, that in turn downloads Ruby dependencies inside the Gemfile: http://bundler.io
	sudo gem install bundler
	#Asciidoctor Reveal.js Configurations
	bundle config --local github.https true
	bundle --path=.bundle/gems --binstubs=.bundle/.bin
	#Install build dependencies using Bundler
	bundler
	#Installs GitBook Client to make easier to generate
	#the book in HTML or PDF instead of using the asciidoctor tool.
	npm install gitbook-cli -g
	gitbook install
	
slides:
	bundle exec asciidoctor-revealjs "README.adoc" -o build/slides.html

html:
	gitbook build ./ ./build/html

pdf:
	gitbook pdf ./ ./build/book.pdf

clean:
	rm -f "build"