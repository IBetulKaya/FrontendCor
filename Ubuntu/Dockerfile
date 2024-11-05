# pull latest ubuntu image
FROM ubuntu:latest

# install openssh-server for sudoers
RUN apt update && apt install openssh-server sudo -y

# install a JDK
RUN apt update && apt install default-jdk -y

# add user 'test' as sudoer
RUN useradd -rm -d /home/test -s /bin/bash -g root -G sudo -u 1001 test 

# give password
RUN  echo 'test:test' | chpasswd

# start the ssh service (for Putty and Winscp)
RUN service ssh start

# expose two ports
# EXPOSE 22 8881

# start command
CMD ["/usr/sbin/sshd","-D"]
