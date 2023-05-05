pipelineJob('record-coverage') {

  definition {
    cps {
      script(readFileFromWorkspace('jobs/pipelines/record_coverage.groovy'))
    }
  }  
}