
//依赖css文件
// You may need an appropriate loader to handle this file type.
// webpack3.x css-loader3.x
require('./css/index.css');
//依赖less文件
require('./css/special.less');


//CommonJs写法
const {add,mul} = require('./js/mathUtil.js');

//ES6写法
import{age,name} from './js/info.js';

console.log(add(20,30));
console.log(mul(20,30));

console.log(name);
console.log(age);


