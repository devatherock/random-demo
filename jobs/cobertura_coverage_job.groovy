pipelineJob('cobertura-coverage') {

  definition {
    cps {
      script(readFileFromWorkspace('jobs/pipelines/cobertura_coverage.groovy'))
    }
  }  
}