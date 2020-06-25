all: slides html pdf

install:
	sudo gem install asciidoctor asciidoctor-pdf asciidoctor-revealjs
	
slides:
	asciidoctor-revealjs slides.adoc -o ../index.html && echo "Slides HTML gerados com sucesso"

html:
	gitbook build ./ ../html

pdf:
	gitbook pdf ./ ../book.pdf

clean:
	rm -rf "../html"
	rm -f ../book.pdf
	rm -f ../slides.html