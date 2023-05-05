String reactiveParamsChoicesScript = """
  if(PARAM_2.equals("some_value") && PARAM_3.equals("some_value")) {
      return ["item_1", "item_2", "item_3"]
  } else if((PARAM_2.equals("E2E_Tests") || (PARAM_2.equals("Real_API"))  && PARAM_3.equals("knox_guard")))  {
      return ["item_1", "item_2", "item_4"]
  } else {
      return ["item_5"]
  }
""".stripIndent()

pipelineJob('reactive-params') {
  parameters {
    activeChoiceParam('PARAM_2') {
      description('First test parameter')
      choiceType('SINGLE_SELECT')
      groovyScript {
        script('return ["some_value", "E2E_Tests", "Real_API"]')
      }
    }

    activeChoiceParam('PARAM_3') {
      description('Second test parameter')
      choiceType('SINGLE_SELECT')
      groovyScript {
        script('return ["some_value", "knox_guard"]')
      }
    }
    
    activeChoiceReactiveParam('SOME_PARAM') {
      description('some description')
      choiceType('SINGLE_SELECT')
      referencedParameter('PARAM_2')
      referencedParameter('PARAM_3')
      groovyScript {
        script(reactiveParamsChoicesScript)
        fallbackScript('return ["item_1"]')
      }
    }
  }
  
  definition {
    cps {
      script(readFileFromWorkspace('jobs/pipelines/reactive_params.groovy')
    }
  }  
}