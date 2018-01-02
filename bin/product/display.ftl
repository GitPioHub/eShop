<#import "../masterpage.ftl" as mp />
<@mp.page  title="Show list">

  <div class="row">
    <h2><a href="/product/${product.id}">${product.name}</a></h2>
	  	  		<div class="product">
				<div class="product-image">
					<img src="${product.pathPhoto}">
				</div>
				<div class="product-info">
					<p><span>Price</span>${product.price} €</p>
					<p><span>Availability</span>In Stock</p>
					<p><span>Shipping</span>Free</p>
					<p><span>Rating</span>
				
						<div class="clear"></div>
					<p></p>
					
					</p>
					<div class="cart"><a href="#">Add to Cart</a></div>
				</div>
				<div class="clear"></div>
			</div>
	
  </div>
</@mp.page>