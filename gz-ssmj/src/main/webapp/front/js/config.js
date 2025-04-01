
var projectName = '高校专业信息管理系统';
/**
 * 轮播图配置
 */
var swiper = {
	// 设定轮播容器宽度，支持像素和百分比
	width: '100%',
	height: '400px',
	// hover（悬停显示）
	// always（始终显示）
	// none（始终不显示）
	arrow: 'none',
	// default（左右切换）
	// updown（上下切换）
	// fade（渐隐渐显切换）
	anim: 'default',
	// 自动切换的时间间隔
	// 默认3000
	interval: 2000,
	// 指示器位置
	// inside（容器内部）
	// outside（容器外部）
	// none（不显示）
	indicator: 'outside'
}

/**
 * 个人中心菜单
 */
var centerMenu = [{
	name: '个人中心',
	url: '../' + localStorage.getItem('userTable') + '/center.jsp'
}
]


var indexNav = [

{
	name: '学校概况',
	url: './pages/xuexiaogaokuang/detail.jsp'
}, 
{
	name: '招生政策',
	url: './pages/zhaoshengzhengce/detail.jsp'
}, 
{
	name: '专业信息',
	url: './pages/zhuanye/list.jsp'
},
{
    name: '课程信息',
    url: './pages/kecheng/list.jsp'
},
{
    name: '在线问答',
    url: './pages/zaixianwenda/list.jsp'
},
{
    name: '新闻资讯',
    url: './pages/news/list.jsp'
},
]

var adminurl =  "http://localhost:8080/gz-ssmj/index.jsp";

var cartFlag = false

var chatFlag = false


chatFlag = true
cartFlag = true


var menu = [{"backMenu":[{"child":[{"buttons":["修改","删除"],"menu":"学生信息","menuJump":"列表","tableName":"xueshengxinxi"}],"menu":"学生管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"课程信息","menuJump":"列表","tableName":"kecheng"}],"menu":"课程管理"},{"child":[{"buttons":["新增","修改","删除"],"menu":"专业信息","menuJump":"列表","tableName":"zhuanye"}],"menu":"专业管理"},{"child":[{"buttons":["删除"],"menu":"报名信息","menuJump":"列表","tableName":"baoming"}],"menu":"报名管理"},{"child":[{"buttons":["修改"],"menu":"学校概况信息","menuJump":"列表","tableName":"xuexiaogaikuang"}],"menu":"学校概况管理"},{"child":[{"buttons":["修改"],"menu":"招生信息","menuJump":"列表","tableName":"zhaoshengzhengce"}],"menu":"招生政策管理"},{"child":[{"buttons":["新增","修改","删除"],"menu":"问题信息","menuJump":"列表","tableName":"liuyanxinxi"}],"menu":"在线问答"},{"child":[{"buttons":["新增","修改","删除"],"menu":"客服管理","tableName":"kefuguanli"},{"buttons":["新增","修改","删除"],"menu":"轮播图管理","tableName":"lunbotuguanli"},{"buttons":["新增","修改","删除"],"menu":"新闻资讯","tableName":"news"}],"menu":"系统管理"}],"frontMenu":[],"roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"buttons":["修改"],"menu":"学生信息","menuJump":"列表","tableName":"xueshengxinxi"}],"menu":"学生管理"},{"child":[{"buttons":[],"menu":"课程信息","menuJump":"列表","tableName":"kecheng"}],"menu":"课程管理"},{"child":[{"buttons":["报名"],"menu":"专业信息","menuJump":"列表","tableName":"zhuanye"}],"menu":"专业管理"},{"child":[{"buttons":["新增"],"menu":"问题信息","menuJump":"列表","tableName":"liuyanxinxi"}],"menu":"在线问答"},{"child":[{"buttons":["删除"],"menu":"报名信息","menuJump":"列表","tableName":"baoming"}],"menu":"报名管理"}],"frontMenu":[],"roleName":"学生","tableName":"xueshengxinxi"}];


var isAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].backMenu.length;j++){
                for(let k=0;k<menus[i].backMenu[j].child.length;k++){
                    if(tableName==menus[i].backMenu[j].child[k].tableName){
                        let buttons = menus[i].backMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}

var isFrontAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].frontMenu.length;j++){
                for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
                    if(tableName==menus[i].frontMenu[j].child[k].tableName){
                        let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}
