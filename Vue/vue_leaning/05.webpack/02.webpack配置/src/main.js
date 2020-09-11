
//CommonJs写法
const {add,mul} = require('./js/mathUtil.js')

//ES6写法
import{age,name} from './js/info.js'

console.log(add(20,30));
console.log(mul(20,30));

console.log(name);
console.log(age);


//依赖css文件
require('./css/index.css')