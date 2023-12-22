pipelineJob('stashed-file') {

  definition {
    cps {
      script(readFileFromWorkspace('jobs/pipelines/stashed_file.groovy'))
    }
  }  
}