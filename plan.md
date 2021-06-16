##  任务

制造一个中等规模（几百万条记录）的对齐、合并良好的数据集，包括训练集和测试集。

即1.中韩互译2.中日互译

##  步骤

###  爬取（一周内，6月16号的工程周会上汇报进度）


<<<<<<< HEAD

#### subhd

1. 
2. 对网页模拟点击获取下载链接

takes an IMDB ID or a Movie / TV Series name and gets it's subtitle from

仅查找评分正面的字幕

从质量较高的网站上爬取srt/txt等格式的足够规模的字幕
[youtube](https://greasyfork.org/zh-CN/scripts/412614-youtube-%E5%8F%8C%E8%AF%AD%E5%AD%97%E5%B9%95%E4%B8%8B%E8%BD%BD-v7-%E4%B8%AD%E6%96%87-%E4%BB%BB%E9%80%89%E7%9A%84%E4%B8%80%E9%97%A8%E5%8F%8C%E8%AF%AD-%E6%AF%94%E5%A6%82%E8%8B%B1%E8%AF%AD/code)
字幕库：http://zmk.pw
SubHD：https://subhd.tv

A4k字幕网：https://www.a4k.net
伪射手（老射手字幕）：https://assrt.net
R3字幕网：https://r3sub.com/index.php
=======
从质量较高的网站上爬取srt/txt/ass等格式的足够规模的字幕

其他字幕网站
[国外字幕集合](https://zhuanlan.zhihu.com/p/91690369)
[国外字幕集合](https://www.mobupdates.com/subscene/)
#### 网站下载成品

#### 爬取
>>>>>>> 3491e35369d766c93cf74f63da52a8d242ce44be

###  baseline数据集（1~2周）

完成最基本的对齐，先造出一个可以使用，但肯定不够良好的数据集

###  高级功能（未知）

`解决黄老师提到的以及可能遇到的问题`

1. 原始语料的错误识别，对于未登录词如何处理。
2. 质量不高：字幕组太多私货。翻译得不好。尽量避免错误样本，几百万的数据，出现100次就足以毁掉模型的结果。
3. 简体和繁体
4. 双语对准

##  额外的想法

1. 多和课题组里的同事请教
2. 通过各种途径（qq群、国外论坛、已工作的网上认识的一些前辈）调研，寻找是否有人有相似的项目经历，取经。

