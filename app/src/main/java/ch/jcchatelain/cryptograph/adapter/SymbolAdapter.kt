package ch.jcchatelain.cryptograph.adapter

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.SyncStateContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ch.jcchatelain.cryptograph.R
import ch.jcchatelain.cryptograph.ShowGraph
import ch.jcchatelain.cryptograph.viewModels.SymbolViewModel
import ch.jcchatelain.cryptograph.webservice.models.BybitSymbol
import com.squareup.picasso.Picasso
import java.lang.StringBuilder

class SymbolAdapter(internal var activity: Activity):RecyclerView.Adapter<SymbolAdapter.SymbolViewHolder>(){

    private var symbols: List<SymbolViewModel> = ArrayList()

    class SymbolViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val symbolIcon: ImageView = itemView.findViewById(R.id.symbolIcon)
        val symbolBaseCurrency: TextView = itemView.findViewById(R.id.symbolBaseCurrency)
        val symbolQuoteCurrency: TextView = itemView.findViewById(R.id.symbolQuoteCurrency)
        val symbolPrice: TextView = itemView.findViewById(R.id.symbolPrice)
        val symbolCardView: CardView = itemView.findViewById(R.id.symbolCardView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SymbolViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.symbol_layout,parent,false)
        return SymbolViewHolder(view)
    }

    override fun onBindViewHolder(holder: SymbolViewHolder, position: Int) {
        holder.symbolBaseCurrency.text = symbols[position].baseCurrency
        holder.symbolQuoteCurrency.text = symbols[position].quoteCurrency
        holder.symbolBaseCurrency.text = symbols[position].baseCurrency
        holder.symbolPrice.text = symbols[position].price.toString()
        if(symbols[position].quoteCurrency !="USDT") {
            holder.symbolCardView.setOnClickListener {
                val symbol = symbols[position].name
                val toPass = Bundle()
                toPass.putString("symbol", symbol)
                val intent =
                    Intent(activity.baseContext, ShowGraph::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtras(toPass)
                activity.baseContext.startActivity(intent)
            }
        }
        var iconUrl = StringBuilder("https://jcchatelain.ch/images/")
            .append(symbols[position].baseCurrency.toLowerCase())
            .append("@2x.png").toString()
        Picasso.with(activity.baseContext).load(iconUrl).into(holder.symbolIcon)
    }

    override fun getItemCount(): Int {
        return symbols.size
    }

    fun updateData(symbols: List<SymbolViewModel>)
    {
        this.symbols = symbols
        notifyDataSetChanged()
    }
}