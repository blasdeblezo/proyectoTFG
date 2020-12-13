function anhadir(){
	 document.getElementsByClassName("form-control").value="";
    provincias = ['Álava','Albacete','Alicante','Almería','Asturias','Ávila','Badajoz','Barcelona','Burgos','Cáceres',
    'Cádiz','Cantabria','Castellón','Ciudad Real','Córdoba','La Coruña','Cuenca','Gerona','Granada','Guadalajara',
    'Guipúzcoa','Huelva','Huesca','Islas Baleares','Jaén','León','Lérida','Lugo','Madrid','Málaga','Murcia','Navarra',
    'Orense','Palencia','Las Palmas','Pontevedra','La Rioja','Salamanca','Segovia','Sevilla','Soria','Tarragona',
    'Santa Cruz de Tenerife','Teruel','Toledo','Valencia','Valladolid','Vizcaya','Zamora','Zaragoza']

    
    var x = document.getElementById("Provincia");
    var option = document.createElement("option");
    option.setAttribute("value",null);
     option.text = "seleccione provincia";
     x.add(option, x[i+1]);
    for(var i=0;i<provincias.length; i++){
         option = document.createElement("option");
        option.setAttribute("value",provincias[i]);
         option.text = provincias[i];
    x.add(option, x[i+1]);
    }

}


function nuevoCazador(){
	var itm = document.getElementById("cazadoryperro");
	  var cln = itm.cloneNode(true);
	  document.getElementById("cazadoryperro").appendChild(cln);
}