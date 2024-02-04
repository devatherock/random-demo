pipelineJob('multi-agents') {

  definition {
    cps {
      script(readFileFromWorkspace('jobs/pipelines/multi_agent.groovy'))
      sandbox()
    }
  }  
}