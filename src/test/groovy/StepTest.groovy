import org.junit.*
import com.lesfurets.jenkins.unit.*
import com.lesfurets.jenkins.unit.BasePipelineTest
import org.mockito.Mockito

import static groovy.test.GroovyAssert.*

class StepTest extends BasePipelineTest {
  def step

  @Before
  void setUp() {
    super.setUp()
    step = loadScript("vars/step.groovy")
  }

  @Test
  void method1Test_true () {
    def partialMock = Mockito.spy(step)
    Mockito.when(partialMock.method2(3)).thenReturn(true)

    def result = partialMock.method1()

    assert 'ok' == result
  }

  @Test
  void method1Test_false () {
    def partialMock = Mockito.spy(step)
    Mockito.doReturn(false).when(partialMock).method2(2)

    def result = partialMock.method1()

    assert 'no' == result
  }
}