(function(t){function e(e){for(var n,s,l=e[0],c=e[1],i=e[2],u=0,d=[];u<l.length;u++)s=l[u],Object.prototype.hasOwnProperty.call(r,s)&&r[s]&&d.push(r[s][0]),r[s]=0;for(n in c)Object.prototype.hasOwnProperty.call(c,n)&&(t[n]=c[n]);p&&p(e);while(d.length)d.shift()();return o.push.apply(o,i||[]),a()}function a(){for(var t,e=0;e<o.length;e++){for(var a=o[e],n=!0,l=1;l<a.length;l++){var c=a[l];0!==r[c]&&(n=!1)}n&&(o.splice(e--,1),t=s(s.s=a[0]))}return t}var n={},r={app:0},o=[];function s(e){if(n[e])return n[e].exports;var a=n[e]={i:e,l:!1,exports:{}};return t[e].call(a.exports,a,a.exports,s),a.l=!0,a.exports}s.m=t,s.c=n,s.d=function(t,e,a){s.o(t,e)||Object.defineProperty(t,e,{enumerable:!0,get:a})},s.r=function(t){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})},s.t=function(t,e){if(1&e&&(t=s(t)),8&e)return t;if(4&e&&"object"===typeof t&&t&&t.__esModule)return t;var a=Object.create(null);if(s.r(a),Object.defineProperty(a,"default",{enumerable:!0,value:t}),2&e&&"string"!=typeof t)for(var n in t)s.d(a,n,function(e){return t[e]}.bind(null,n));return a},s.n=function(t){var e=t&&t.__esModule?function(){return t["default"]}:function(){return t};return s.d(e,"a",e),e},s.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)},s.p="/";var l=window["webpackJsonp"]=window["webpackJsonp"]||[],c=l.push.bind(l);l.push=e,l=l.slice();for(var i=0;i<l.length;i++)e(l[i]);var p=c;o.push(["56d7","chunk-vendors"]),a()})({"07a7":function(t,e,a){},"16a3":function(t,e,a){"use strict";a("cd8c")},"56d7":function(t,e,a){"use strict";a.r(e);var n=a("2b0e"),r=a("8c4f"),o=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("router-view",{key:t.$route.fullPath})],1)},s=[],l=a("b59b"),c=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",t._l(t.model[":items"],(function(e,n){return a(t.renderTo(e),{key:n,tag:"component",attrs:{"child-model":e,"cq-path":t.childPath+n}})})),1)},i=[],p=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{attrs:{"data-cq-data-path":t.cqPath}},[a("div",{domProps:{innerHTML:t._s(t.text)}}),t.isEmpty?a("div",{staticClass:"cq-placeholder",attrs:{"data-emptytext":"Text"}}):t._e()])},u=[],d=l["c"].mapTo({name:"AppText",resourceType:"vue-aem-spa/components/content/text",mixins:[l["d"]],computed:{text:function(){return this.model.text},isEmpty:function(){return!this.text}}}),m=d,h=a("2877"),v=Object(h["a"])(m,p,u,!1,null,null,null),f=v.exports,b=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{attrs:{"data-cq-data-path":t.cqPath}},[a("nav",{staticClass:"navbar navbar-expand-lg navbar-dark bg-primary"},[a("router-link",{staticClass:"navbar-brand",attrs:{to:"/content/vue-aem-spa/home.html"}},[t._v("Home")]),t._m(0),a("div",{staticClass:"collapse navbar-collapse",attrs:{id:"navbarColor02"}},[a("ul",{staticClass:"navbar-nav mr-auto"},t._l(t.childrenModel,(function(e,n){return a("li",{key:n,staticClass:"nav-item"},[a("router-link",{key:n,staticClass:"nav-link",class:{active:t.isCurrent(e[t.CONSTANTS.PATH])},attrs:{to:e[t.CONSTANTS.PATH]+".html"}},[t._v(" "+t._s(e.title)+" "),t.isCurrent(e[t.CONSTANTS.PATH])?a("span",{staticClass:"sr-only"},[t._v("(current)")]):t._e()])],1)})),0),t._m(1)])],1)])},C=[function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("button",{staticClass:"navbar-toggler",attrs:{type:"button","data-toggle":"collapse","data-target":"#navbarColor02","aria-controls":"navbarColor02","aria-expanded":"false","aria-label":"Toggle navigation"}},[a("span",{staticClass:"navbar-toggler-icon"})])},function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("form",{staticClass:"form-inline"},[a("input",{staticClass:"form-control mr-sm-2",attrs:{type:"search",placeholder:"Search","aria-label":"Search"}}),a("button",{staticClass:"btn btn-outline-light my-2 my-sm-0",attrs:{type:"submit"}},[t._v("Search")])])}],y=l["c"].mapTo({name:"AppNavbar",resourceType:"vue-aem-spa/components/content/nav",mixins:[l["d"]],methods:{isCurrent(t){return t===this.$route.path.replace(".html","")}},computed:{rootPath(){return this.$route.path}}}),g=y,_=(a("16a3"),Object(h["a"])(g,b,C,!1,null,null,null)),T=_.exports,x={AppText:f,AppNavbar:T},P=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{class:t.gridClassName,attrs:{"data-cq-data-path":t.cqPath}},[t._l(t.model[t.CONSTANTS.ITEMS],(function(e,n){return a(t.renderTo(e),{key:n,tag:"component",class:t.componentClass(n),attrs:{"child-model":e,"cq-path":t.childPath+n}})})),t.allowedComponents.applicable?a("div",{staticClass:"aem-AllowedComponent--list new section aem-Grid-newComponent"},[a("div",{staticClass:"aem-AllowedComponent--title",attrs:{"data-text":"Layout Container"}}),t._l(t.allowedComponents.components,(function(t,e){return a("div",{key:e,staticClass:"aem-AllowedComponent--component cq-placeholder placeholder",attrs:{"data-cq-data-path":t.path,"data-emptytext":t.title}})}))],2):t._e(),a("div",{staticClass:"new section aem-Grid-newComponent",attrs:{"data-cq-data-path":t.parSysPath}})],2)},w=[],O=l["c"].mapTo({name:"AppResponsiveGrid",resourceType:"wcm/foundation/components/responsivegrid",mixins:[l["d"]],components:x,methods:{componentClass(t){return!!this.model.columnClassNames[t]&&this.model.columnClassNames[t]}},computed:{gridClassName(){return!!this.model.gridClassNames&&this.model.gridClassNames}}}),N=O,A=Object(h["a"])(N,P,w,!1,null,null,null),S=A.exports,q=l["c"].mapTo({name:"AppPage",components:{...x,AppResponsiveGrid:S},resourceType:"vue-aem-spa/components/structure/page",mixins:[l["d"]]}),j=q,k=Object(h["a"])(j,c,i,!1,null,null,null),E=k.exports;let $="/content/vue-aem-spa/home.html";var M={el:"#app",router:new r["a"]({mode:"history"}),components:{AppPage:E},methods:{onModelChange(t){let e=[{path:t[l["a"].PATH]+".html",component:E,props:{cqPath:this.cqPath,childModel:t}}];for(let a in t[l["a"].CHILDREN])e.push({path:a+".html",component:E,props:{cqPath:a+"/"+l["a"].JCR_CONTENT,childModel:t[l["a"].CHILDREN][a]}});this.$router.addRoutes(e),"/"===this.$router.currentRoute.path&&this.$router.push($)}},cmsPath:"",mixins:[l["b"]]},H=M,R=(a("c796"),Object(h["a"])(H,o,s,!1,null,null,null)),G=R.exports;n["a"].config.productionTip=!1,n["a"].config.silent=!0,n["a"].config.debug=!1,n["a"].config.devtools=!1,n["a"].use(r["a"]),new n["a"](G)},c796:function(t,e,a){"use strict";a("07a7")},cd8c:function(t,e,a){}});