<#import "../masterpage.ftl" as mp>

<@mp.page title="myorder" >

<h1> Liste des commandes </h1>
<#list order as orders>
<div class="container">
	<table id="cart" class="table table-hover table-condensed">
    				<thead>
						<tr>
							<th style="width:50%"><a href="/order/${orders.id}">Commande n° ${orders.id}</a></th>
							
							<th style="width:10%">Date</th>
							<th style="width:8%">Total produits</th>
							<th style="width:22%" class="text-center">prix</th>
							<th style="width:10%">État</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-2 hidden-xs"><img src="http://placehold.it/100x100" alt="..." class="img-responsive"/></div>
									<div class="col-sm-10">
										<h4 class="nomargin">Liste des produits</h4>
										<p></p>
									</div>
								</div>
							</td>
							<td data-th="Price">${orders.date}</td>
							<td data-th="Quantity">
								
							</td>
							<td data-th="Subtotal" class="text-center">1.99</td>
							<td class="actions" data-th="">
								<button class="btn btn-info btn-sm"><i class="fa fa-refresh"></i></button>
								<button class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></button>								
							</td>
						</tr>
					</tbody>
					<tfoot>
						<tr class="visible-xs">
							<td class="text-center"><strong>Total 1.99</strong></td>
						</tr>
						<tr>
							
							<td colspan="4" class="hidden-xs"></td>
							<td class=""><strong>Total $1.99</strong></td>
							<#if orders.state == "IN_PROGRESS">
								     <td><a href="#" class="btn btn-success btn-block">Checkout <i class="fa fa-angle-right"></i></a></td>
								<#else>	   
								</#if>
							
						</tr>
					</tfoot>
				</table>
			</div>
  	 </#list>
  	 <td><a href="/product/index/" class="btn btn-warning"><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
 	
</table>

 </@mp.page>
