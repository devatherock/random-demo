pipelineJob('jacoco-coverage') {

  definition {
    cps {
      script(readFile('pipelines/jacoco-coverage.groovy'))
    }
  }  
}