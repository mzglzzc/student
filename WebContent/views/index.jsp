<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Basic Tabs - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="/static/jquery-easyui-1.5.1/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/static/jquery-easyui-1.5.1/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/static/css/main.css">
</head>
<body class="easyui-layout">
    <div region="north" style="height:160px;">
		<h1>标题</h1>
	</div>
	<div data-options="region:'west',split:true,title:'Navigator'" style="width:180px;">
		<div class="easyui-accordion" data-options="multiple:true" >
	        <div title="Language">
	            <ul>
	            	<li><a onclick="addTab('add1','t1.jsp')">add1</a></li>
	            	<li><a onclick="addTab('add2','t2.jsp')">add2</a></li>
	            	<li><a onclick="addTab('add3','t1.jsp')">add3</a></li>
	            </ul>
	        </div>
	        <div title="Java">
	            <p>Java (Indonesian: Jawa) is an island of Indonesia. With a population of 135 million (excluding the 3.6 million on the island of Madura which is administered as part of the provinces of Java), Java is the world's most populous island, and one of the most densely populated places in the world.</p>
	        </div>
	        <div title="C#">
	            <p>C# is a multi-paradigm programming language encompassing strong typing, imperative, declarative, functional, generic, object-oriented (class-based), and component-oriented programming disciplines.</p>
	        </div>
	        <div title="Ruby">
	            <p>A dynamic, reflective, general-purpose object-oriented programming language.</p>
	        </div>
	        <div title="Fortran">
	            <p>Fortran (previously FORTRAN) is a general-purpose, imperative programming language that is especially suited to numeric computation and scientific computing.</p>
	        </div>
	    </div>
	</div>
	<div id="content" region="center">
		<div class="easyui-tabs" plain="true" id="tab1">
	        <div title="About" data-options="closable:true">
	            lalalalala
	        </div>
	        <div title="Help" data-options="iconCls:'icon-help',closable:true">
	            <iframe scrolling="auto" frameborder="0"  src="t2.jsp" style="width:100%;height:100%;"></iframe>
	        </div>
	    </div>
	</div>
    <script type="text/javascript" src="/static/jquery-easyui-1.5.1/jquery.min.js"></script>
    <script type="text/javascript" src="/static/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
    <script>
    	function addTab(title, url){
    		if ($('#tab1').tabs('exists', title)){
    			$('#tab1').tabs('select', title);
    		} else {
    			var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
    			$('#tab1').tabs('add',{
    				title:title,
    				content:content,
    				closable:true
    			});
    		}
    	}
    </script>
</body>
</html>