pipelineJob('passwords-job') {
  parameters {
    nonStoredPasswordParam('SECRET_ONE', 'First secret')
  }

  definition {
    cps {
      script(readFileFromWorkspace('jobs/pipelines/passwords.groovy'))
      sandbox()
    }
  }  
}