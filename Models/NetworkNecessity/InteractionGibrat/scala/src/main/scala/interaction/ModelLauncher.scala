package interaction

import java.io.File
import scala.util.Random
import Jama.Matrix

class ModelLauncher {

  var logmse: Double = 0
  var mselog: Double = 0

  def main(populations: File, distances: File, feedbackDistances: File,
    gr: Double, gw: Double, gg: Double, gd: Double,
    fw: Double, fg: Double, fd: Double,
    replication: Int) = {

    //println("Params : " + growthRate + " ; " + gravityWeight + " ; " + gravityGamma + " ; " + gravityDecay + " ; " + feedbackWeight + " ; " + feedbackGamma+ " ; " + feedbackDecay)
    //var t = System.currentTimeMillis()

    /*object model with InteractionModel  {
      override def growthRate: Double = gr
      override def gravityWeight: Double = gw
      override def gravityGamma: Double = gg
      override def gravityDecay: Double = gd
      override def feedbackWeight: Double = fw
      override def feedbackGamma: Double = fg
      override def feedbackDecay: Double = fd
      override def populations: File = pops
      override def distances: File = dists
      override def feedbackDistances: File = fdists
    }*/

    InteractionModel.setup(populations, distances, feedbackDistances)
    val pop: Matrix = InteractionModel.run(gr, gw, gg, gd, fw, fg, fd)

    logmse = InteractionModel.logmse(pop)
    mselog = InteractionModel.mselog(pop)

    //println("Indicators : logmse = " + logmse)
    //println("Ellapsed Time : " + (System.currentTimeMillis() - t) / 1000.0 + "\n")

  }

}
