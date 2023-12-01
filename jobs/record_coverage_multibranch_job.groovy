multibranchPipelineJob('record-coverage-multibranch') {
  branchSources {
    branchSource {
      source {
        github {
          id(UUID.nameUUIDFromBytes('java-demo'.bytes).toString())
          repoOwner('devatherock')
          repository('java-demo')
          repositoryUrl('https://github.com/devatherock/java-demo.git')
          configuredByUrl(true)
          
          traits {
            gitHubBranchDiscovery {
              strategyId(3)
            }

            cloneOptionTrait {
              extension {
                shallow(false)
                noTags(false)
                reference('')
                timeout(15)
                depth(0)
              }
            }

            wipeWorkspaceTrait()
          }
        }
      }
    }
  }

  orphanedItemStrategy {
    discardOldItems {
      daysToKeep(14)
    }
  }  
}