app.directive('attrType',attrType);
function attrType() {

    return{

        restrict:'A',
        template:"<div class='jumbotron'>Attribute Type Usage<pre>Restrict:'A'</pre></div>"
    }
}
