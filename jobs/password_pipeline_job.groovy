pipelineJob('password-pipeline-job') {

  definition {
    cps {
      script(readFileFromWorkspace('jobs/pipelines/password_pipeline.groovy'))
      sandbox()
    }
  }  
}