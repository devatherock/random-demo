pipelineJob('trigger-another') {

  definition {
    cps {
      script(readFileFromWorkspace('jobs/pipelines/trigger_another.groovy'))
    }
  }  
}