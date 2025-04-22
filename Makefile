install:
	sudo gem install asciidoctor asciidoctor-pdf asciidoctor-revealjs
	
slides:
	asciidoctor-revealjs slides.adoc -o ../index.html && echo "Slides HTML gerados com sucesso"

clean:
	rm -rf "../html"
	rm -f ../slides.html
