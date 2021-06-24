ant匹配规则
字符wildcard　　　　描述
?　　　　　　　　　匹配一个字符
*　　　　　　　　　匹配0个及以上字符
**　　　　　　　　 匹配0个及以上目录directories

com/t?st.jsp - 　　　　　　　　　　  匹配: com/test.jsp  ,  com/tast.jsp  ,  com/txst.jsp
com/*.jsp - 　　　　　　　　　　　　匹配: com文件夹下的全部.jsp文件
com/**/test.jsp - 　　　　　　　　　匹配: com文件夹和子文件夹下的全部.jsp文件,
org/springframework/**/*.jsp - 　  匹配: org/springframework文件夹和子文件夹下的全部.jsp文件
org/**/servlet/bla.jsp - 　　　　　　匹配: org/springframework/servlet/bla.jsp  ,  org/springframework/testing/servlet/bla.jsp  ,  org/servlet/bla.jsp