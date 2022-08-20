package main

import (
	"fmt"
	"log"

	"github.com/flosch/pongo2/v6"
)

const template string = `
<html>
  <head>
    <title>{{title}}</title>
  </head>
  <body>
    {{ title }}
    <div>

        {% for item in number_list %}
        test 1: {{item}} 
        {% endfor %}

        {% for item in object_list %}
        test 2: {{item[0]}}
        {% endfor %}
    </div>
  </body>
</html>
`

func main() {
	template, err := pongo2.FromString(template)
	if err != nil {
		log.Fatal(err)
	}

	out, err := template.Execute(pongo2.Context{
		"number_list": []int{1, 2, 3},
		"object_list": []interface{}{[]int{1}, []int{2}, []int{3}},
		"title":       "This is the title",
	})
	if err != nil {
		log.Fatal(err)
	}
	fmt.Println(out)
}
