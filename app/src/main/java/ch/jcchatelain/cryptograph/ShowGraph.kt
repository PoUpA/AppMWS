package ch.jcchatelain.cryptograph

import android.R
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import ch.jcchatelain.cryptograph.webservice.api.BybitClient
import com.liihuu.klinechart.KLineChartView
import com.liihuu.klinechart.component.Candle
import com.liihuu.klinechart.model.KLineModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*


class ShowGraph : AppCompatActivity() {
    private fun loadGraph(Symbol: String = "BTCUSD") {
        val api = BybitClient.retrofit
        GlobalScope.launch(Dispatchers.IO) {
            val apiGraph = api.getKlineInversePerpetual(
                symbol = Symbol,
                fromTime = getDaysAgo(360).toInstant().epochSecond
            )
            var datas = apiGraph.result
            var k_line_chart =
                findViewById<KLineChartView>(ch.jcchatelain.cryptograph.R.id.k_line_chart)
            k_line_chart.candle.candleStyle = Candle.CandleStyle.OHLC
            datas.forEach {
                k_line_chart.addData(
                    KLineModel(
                        it.open.toDouble(),
                        it.high,
                        it.low,
                        it.open,
                        it.close
                    )
                )
            }
        }
    }

    fun getDaysAgo(daysAgo: Int): Date {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, -daysAgo)

        return calendar.time
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ch.jcchatelain.cryptograph.R.layout.activity_show_graph)

        val bundle = intent.extras
        val symbol = bundle?.get("symbol").toString()
        loadGraph(symbol)
    }
}