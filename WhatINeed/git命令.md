1. ��github�ϵĹ��̿�¡�����ء�
git clone https://github.com/wuanlife/Jianbing_Android.git
2. �鿴����Ŀ¼���޸�״̬��
git status
3. ��ӵ�������������
git add . 
4. ��ӵ���������
git commit -m "���git�����ļ�"
5. ��ӵ�github��
git push origin master
�����˺����롣
6. 
git pull origin master

����ƻ�-github�˺�
https://github.com/wuanlife/Jianbing_Android



///////////////////////////////////////////////////////////////////////
����԰���������������sshkey

ssh-keygen -t rsa -C "xxxxx@xxxxx.com"# Creates a new ssh key using the provided email
# Generating public/private rsa key pair...
�鿴���public key����������ӵ� Git @ OSC http://git.oschina.net/keys

cat ~/.ssh/id_rsa.pub
# ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQC6eNtGpNGwstc....
��Ӻ����նˣ�Terminal��������

ssh -T git@git.oschina.net
������

Welcome to Git@OSC, yourname! 
��֤����ӳɹ���
/////////////////////////////////////////////////////////////////////

