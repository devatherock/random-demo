pipelineJob('jacoco-coverage') {

  definition {
    cps {
      script(readFileFromWorkspace('pipelines/jacoco_coverage.groovy'))
    }
  }  
}