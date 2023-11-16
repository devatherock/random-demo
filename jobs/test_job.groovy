pipelineJob('test') {

  definition {
    cps {
      script(readFileFromWorkspace('jobs/pipelines/test.groovy'))
    }
  }  
}