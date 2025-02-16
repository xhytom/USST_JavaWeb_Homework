# 作业要求

## 《互联网广告投放生态链的设计与实践》

### 【基本要求】

开发一个广告投放与管理系统，以及至少一个网络在线网店系统，至少一个在线新闻网站系统，共三种子系统。其中网络在线商店和在线新闻网站可以有多个。

演示功能，最后每个小组完成一份实验报告，需上交纸质版和电子版。

系统开发可以分组或个人独立完成，每个小组建议不超过7人，设组长1名，副组长不超过两名。工作量需要有佐证。

鼓励团队分工协作，尽量避免单干。鼓励调用最新的工具，如大模型API。

### 【详细功能要求】

#### l广告投放与管理系统

Ø 广告主-注册后，可以对广告信息进行增删改（通常可以包括，相关标准格式或字数的广告文字，各种大小的标准logo或各种大小标准的广告图片，广告的详细内容（如名称，信息描述，一个网址或者页面，分类，关键词等等各种属性），可以根据需要自行设计以实现精准用户投放）可以把相关的广告信息放在一个单独的网站上）；并可以进行投放广告操作，还可以查看检索自己的广告的点击率，转化率，投放效果，收益，投放位置网站以及分时段分日月年等统计分析信息，可进一步做可视化分析，全面掌握广告的投放效果和收益。

Ø 互联网站长-注册后，可以查看浏览当前发布的广告，可以查看获取广告发布的API接口，可以查询统计广告投放情况和收益，可以进一步做数据分析可视化。

Ø 管理员-可以对整个网站的广告信息，用户信息，收益配置，广告投放频率，投放时间等等进行管理，修改等。

#### 在线网店系统

简单的网络销售，主要有分类浏览查看和搜索商品，加入购物车，下订单等基本流程。可以不用注册登录。但需提供相应的一个或多个广告位，可以提供一种或者种广告信息形式，例如logo，banner，滚动字幕文字，弹出小窗口或图片，浮动图片或文字，大幅插入图片文字等，并可以方便地调用广告API接口显示广告信息供用户点击，并显示广告。广告信息的显示应该是随机动态的，不能是固定静态的。

#### 在线新闻网站系统

简单的新闻网站，有新闻分类浏览，查看，搜索等功能，新闻的数据来源可以动态管理后台增删改，也可以是自动爬虫定时抓取，或者静态数据库手工导入。广告位的要求同网店系统。

####  各网站的广告信息自动联动、跟踪和广告精准投放

设计一个策略，尽可能地实现新闻网站和在线网店等不同网站用户的自动识别和跟踪，并精准投送。同时尽可能设计一些比较相关的广告，方便进行演示。例如：用户在购物网站经常浏览查看，下订单，搜索的产品，当其访问任何新闻网站或购物网站时，尽可能显示该类型的广告。如果在新闻网站曾经点击浏览过相应广告，则当其访问任何新闻网站或购物网站时尽量显示相关广告。或经常查看科技电脑方面的新闻，则在其他网站推送相关的广告。

设计实现广告信息和用户行为的相关性，可以通过标签，分类标识或者大语言模型等方式。

也可以设计集成一个推荐系统。

### 【技术要求】

系统需自行开发，不得直接抄袭开源或网上下载的完整复杂系统。

系统前端需进行一定设计，不得采用白底黑字的简单无设计页面。可以借用现成的模版网页进行修改，也可以采用用第三方的前端框架（推荐，bootstrap，element，vue.JS等）

每个子系统均独立运行在一个web网站上（至少三台服务器，需模拟出真实跨域跨网站）。

系统架构要满足MVC分层开发的要求，前后端代码分离，数据库访问层分离。

系统开发完成后，要求所有软件部署上线运行，并可以通过浏览器直接输入相应网址在校园网中进行正常访问。

所有项目源代码需要上传到github，并采用github进行项目版本管理，实现多人协作（请自行协商好相关的配置，开发平台版本，避免协作出现问题），项目最后需要提交github贡献截图和网址,作为小组成员的工作量评估依据。

 
