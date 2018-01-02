<#import "../masterpage.ftl" as mp>


<#assign css = "
<!-- test -->
">

<@mp.page title="display products" css=css>

	  <h1>Bienvenue dans la liste des produits, faites votre choix!</h1>  
	
	  	  <div class="containerProducts">
	  	  <div id="pricing-table" class="clear">	 
	  	      <#list products as product> 			
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
		
		 	</#list>
		</div>
	  	
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  

	  

    
 </@mp.page>
