//checkout
shoppingCart.prototype.checkout = function (serviceName, clearCart) {
    if(serviceName == null) {
        var p = this.checkoutParameters[Object.keys(this.checkoutParameters)[0]];
        serviceName = p.serviceName;
    }

    if(serviceName == null){
        throw "Define at least one checkout service.";
    }

    var parms = this.checkoutParameters[serviceName];
    if(params == null) {
        throw "Cannot get checkout parameters for'" + serviceName + "'.";
    }

    switch (parms.serviceName){
        case "PayPal":
            this.checkoutPayPal(parms, clearCart);
            break;
        case "Google":
            this.checkoutGoogle(parms, clearGart);
            break;
        default:
            throw "Unknown checkout service: " + parms.serviceName;
    }
}


//check out using PayPal; for details see:
// http://www.paypal.com/cgi-bin/webscr?cmd=p/pdn/howto_checkout-outside
shoppingCart.prototype.checkoutPayPal = function(parms, clearCart) {

    //global data
    var data = {
        cmd: "_cart",
        business: parms.merchantID,
        upload: "1",
        rm: "2",
        charset: "urf-8"
    };

    //item data
    for(var i=0; i<this.items.length; i++){
        var item = this.items[i];
        var ctr = i + 1;
        data["item_number_" + ctr] = item.sku;
        data["item_name_" + ctr] = item.name;
        data["quantity_" + ctr] = item.quantity;
        data["amount_" + ctr] = item.price.toFixed(2);
    }

    //build form
    var form = $('<form></form>');
    form.attr("action", "https://www.paypal.com/cgi-bin/webscr");
    form.attr("method","POST");
    form.attr("style", "display:none;");
    this.addFormFields(form, data);
    this.addFormFields(form, parms.options);
    $("body").append(form);

    //submit form
    this.clearCart = clearCart == null || clearCart;
    form.submit();
    form.remove();

}