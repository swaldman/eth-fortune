package ethfortune.contract

import org.specs2._
import Testing._

import com.mchange.sc.v1.consuela.ethereum.stub.sol

class FortuneSpec extends Specification with AutoSender { def is = sequential ^ s2"""
  Fortune...
      should be initialized with a single fortune                 ${e1}
      adding a fortune should bring the fortune count to two      ${e2}
      the new fortune should be the fortune added                 ${e3}
  """

  val fortune = Fortune( DefaultSender.contractAddress(0) )

  def e1 : Boolean = fortune.constant.countFortunes().widen == 1

  def e2 : Boolean = {
    fortune.transaction.addFortune( "Love is the answer" )
    fortune.constant.countFortunes().widen == 2
  }

  def e3 : Boolean = {
    fortune.constant.fortunes(sol.UInt(1)) ==  "Love is the answer"
  }

}

