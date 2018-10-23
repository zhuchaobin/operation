# 为自己的应用程序打一个基础镜像，把基础的软件安装好，并且包括启动的entrypoint
FROM registry-vpc.cn-beijing.aliyuncs.com/tianan/centos73:latest

# 上面提到了，RDC会把container-app.tgz放到Dockerfile的同级目录，所以可以这么写，把RDC打出来的软件包拷贝到镜像中
COPY kl-product.tgz /product-war.tar.gz
