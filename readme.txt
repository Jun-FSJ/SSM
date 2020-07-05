此项目是SSM+IDEA+Maven的一个小web项目，有基础的crud+分页查询+简单的搜索

如果以后的项目怎么创建呢？

模仿这个项目就行
首先新建一个maven项目，
在pom.xml新增<packaging>war</packaging>
<groupId>org.example</groupId>
<artifactId>SSM</artifactId>
<version>1.0-SNAPSHOT</version>
<packaging>war</packaging>
添加依赖。
在src.main下新建webapp文件夹，图片里有路径的位置。webapp文件夹我这也有
在将相关xml文件复制到resources文件夹下
在右侧maven tomcat7:run就行了


项目的坑：
注意注意:
1.更新书籍的时候，执行updateBook()方法前 一定要传入id 这里是bookID。
在修改的页面的表单中toUpdateBook.jsp 提交一定要带上id，可以将其设置成隐藏域 不然会修改不成功
因为在mapper.xml中的sql语句中
     update ssmbuild.books
         set bookName = #{bookName},bookCounts = #{bookCounts},detail = #{detail}
           where bookID = #{bookID}
          要根据id的值来进行修改

2.添加书籍,如果数据库里有相同的书名，就更新书籍的数量，如果没有就新增书籍
添加数据,如果jsp传入了id，那就必须要在表单提交中填入id的值，不能不填id，不然会报400
在添加的页面中toAddBook.jsp不能传入隐藏域id,不然会报400