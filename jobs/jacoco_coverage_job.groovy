pipelineJob('jacoco-coverage') {

  definition {
    cps {
      script(readFileFromWorkspace('jobs/pipelines/jacoco_coverage.groovy'))
    }
  }  
}