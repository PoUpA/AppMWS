package ch.jcchatelain.cryptograph

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import ch.jcchatelain.cryptograph.adapter.SymbolAdapter
import ch.jcchatelain.cryptograph.viewModels.SymbolViewModel
import ch.jcchatelain.cryptograph.webservice.api.BybitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class HomeScreen : AppCompatActivity() {

    internal lateinit var adapter: SymbolAdapter

    private fun loadSymbols(){
        val api = BybitClient.retrofit
        GlobalScope.launch(Dispatchers.IO) {
            val apiSymbols = api.getSymbols()
            var symbols = apiSymbols.result
            var symbolViewItems = ArrayList<SymbolViewModel>()
            symbols.forEach {
                var item: SymbolViewModel = SymbolViewModel(name = it.name,baseCurrency = it.baseCurrency,quoteCurrency = it.quoteCurrency,price = 0f)
                val ticker = api.getTicker(it.name)
                item.price = ticker.result[0].lastPrice.toFloat()
                symbolViewItems.add(item)
            }
            runOnUiThread {
                adapter.updateData(symbolViewItems)
                val swipeRefreshLayout = findViewById<SwipeRefreshLayout>(R.id.swipe_refresh)
                swipeRefreshLayout.isRefreshing = false
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_screen)
        adapter = SymbolAdapter(this@HomeScreen)
        val recyclerView: RecyclerView = findViewById(R.id.symbol_recycler_view)
        val swipeRefreshLayout = findViewById<SwipeRefreshLayout>(R.id.swipe_refresh)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        swipeRefreshLayout.post{
            loadSymbols()
        }
        swipeRefreshLayout.setOnRefreshListener{
            loadSymbols()
        }
    }
}
