pipelineJob('stashed-file') {

  parameters {
    stashedFile 'inputFile'
  }

  definition {
    cps {
      script(readFileFromWorkspace('jobs/pipelines/stashed_file.groovy'))
    }
  }  
}