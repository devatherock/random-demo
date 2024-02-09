pipelineJob('password-dsl-job') {
  parameters {
    nonStoredPasswordParam('SECRET_ONE', 'First secret')
  }

  definition {
    cps {
      script(readFileFromWorkspace('jobs/pipelines/password_dsl.groovy'))
      sandbox()
    }
  }  
}