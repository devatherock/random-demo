pipelineJob('stashed-file') {

  parameters {
    stashedFile(name: 'inputFile', description: 'some file')
  }

  definition {
    cps {
      script(readFileFromWorkspace('jobs/pipelines/stashed_file.groovy'))
    }
  }  
}