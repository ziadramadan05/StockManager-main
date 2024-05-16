//buyButton.setOnAction(event -> {
//Stocks stock = getTableView().getItems().get(getIndex());
//TextField quantityField = quantityFieldsMap.get(stock);
//    if (quantityField != null) {
//        try {
//String quantity = quantityField.getText();
//int purchasedQuantity = Integer.parseInt(quantity);
//            if (purchasedQuantity <= stock.getStocknumber()) {
//int remainingStock = stock.getStocknumber() - purchasedQuantity;
//                System.out.println("Buying " + purchasedQuantity + " of " + stock.getStockname());
//        System.out.println("Remaining stock of " + stock.getStockname() + ": " + remainingStock);
//        stock.setStocknumber(remainingStock);
//writeDataToFile(StocksList);
//                tableView.refresh();
//            } else {
//                    System.out.println("Not enough stock available.");
//            }
//                    } catch (NumberFormatException e) {
//        System.out.println("Please enter a valid integer quantity.");
//        }
//                }
//                });
