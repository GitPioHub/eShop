<#import "../masterpage.ftl" as mp>



<@mp.page title="home" >
	<div class="container-home">
		<h1 class="title">Welcome to Atlantes<h1>
		<h2 class="subtitle">On vend vraiment de la merde</h2>
		
	
		<div id="pricing-table" class="clear">	 	
			<h2 class="subtitle">Nos produits les plus populaires !	</h2>				
		    <#list products as product>
				 <#if product.quantity < 5>	
	   			<div class="plan" id="most-popular">
	        		<h3><a href="/product/${product.id}">${product.name}</a><span>${product.price} €</span></h3>
	        			<#if product.quantity == 0>
	        			<a class="signup" href="">Sold-out!</a> 
	       			
	       				<#else>   
	       					<a class="signup" href="">Ajouter au panier</a>  
	       				</#if>     
	        				<ul>
		            			<li><b> Description :</b> ${product.description}</li>
		            			<li><b>${product.quantity}</b> restant</li>
	            			</ul> 
	            		<img class="photoMini" src="${product.pathPhoto}">					    			
	    		</div>	    	
		 	<#else>
		 	</#if>
		 	</#list>
		</div>
	</div>


 </@mp.page>