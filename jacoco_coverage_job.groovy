pipelineJob('jacoco-coverage') {

  definition {
    cps {
      script(readFileFromWorkspace('pipelines/jacoco-coverage.groovy'))
    }
  }  
}