package ch.jcchatelain.cryptograph.viewModels

data class SymbolViewModel(
    var name: String,
    var baseCurrency: String,
    var quoteCurrency: String,
    var price: Float,
)