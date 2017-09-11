# NEM FIAT / XEM Converter

Java API for converting any FIAT Currency to XEM!

Simplest and Straight forward API for converting any currency to XEM!

<h2>To Xem</h2>

```java

FiatsXem converter = PriceConverter.fromFiat("PHP",2.00).fromFiat("USD",2.00).toXem();

	
BigDecimal xemFromCad = converter.getXemPriceFor("PHP"); // returns xem equivalent of PHP 2.00
BigDecimal xemFromUsd = converter.getXemPriceFor("USD"); // returns xem equivalent of USD 2.00


```

<h2>To Fiat</h2>

```java
XemFiat converter = PriceConverter
	.fromXem(2.00)
	.toFiat("USD")
	.toFiat("PHP")
	.convert();
	
BigDecimal phpXemPrice = converter.getPriceOf("PHP"); // returns the PHP price of XEM 2.00
BigDecimal usdXemPrice = converter.getPriceOf("USD"); // returns the USD price of XEM 2.0


```

<h2>Search Coin</h2>
<h3>Get all coins</h3>

```java
Coins CoinSearch.getAllCoins()
```

<h3>Search a specific coin</h3>

```java
Coin searchCoin(String symbol);
```

<h2>Support</h2>
Need help integration your Java Application with NEM.io Platform? I can definitely help you with that, send me a message via 

[telegram](https://web.telegram.org/#/im?p=@brambear)

Tips are appreciated but not required. :bowtie: :muscle: :metal:  
XEM: NA6IT2-ZSTQLT-YO223Z-ZMH2J7-2GVG7G-ZY72FN-47IF  
BTC: 3JYAYPxN9RL4UvbxMd1svbQynMpFbf5ehy 

<sub>Copyright (c) 2017</sub>
