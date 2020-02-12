#!/bin/bash
sudo yum install rng-tools -y
sudo rngd -r /dev/urandom 
sudo /usr/sbin/create-munge-key -r
sudo chown munge: /etc/munge/munge.key
sudo chmod 400 /etc/munge/munge.key

sudo cp /etc/munge/munge.key /scratch/munge.key

sudo chown -R munge: /etc/munge/ /var/log/munge/
sudo chmod 0700 /etc/munge/ /var/log/munge/

#wait for meta to have key before starting munge
while [ ! -f /scratch/meta.haskey ]
do
  sleep 10
done

sudo systemctl enable munge
sudo systemctl start munge

cd /software
sudo wget http://www.schedmd.com/download/latest/slurm-18.08.3.tar.bz2
sudo yum install rpm-build
sudo yum install perl -y
sudo yum install 'perl(ExtUtils::MakeMaker)' -y
sudo rpmbuild -ta slurm-18.08.3.tar.bz2

sudo mkdir /software/slurm-rpms
sudo cp /root/rpmbuild/RPMS/x86_64/* /software/slurm-rpms

sudo touch /scratch/rpm.done

sudo yum --nogpgcheck localinstall /software/slurm-rpms/* -y

sudo cp /scratch/slurm.conf /etc/slurm/slurm.conf
sudo mkdir /var/spool/slurmctld
sudo chown slurm: /var/spool/slurmctld
sudo chmod 755 /var/spool/slurmctld
sudo touch /var/log/slurmctld.log
sudo chown slurm: /var/log/slurmctld.log
sudo touch /var/log/slurm_jobacct.log /var/log/slurm_jobcomp.log
sudo chown slurm: /var/log/slurm_jobacct.log /var/log/slurm_jobcomp.log
sudo touch /var/run/slurmctld
sudo chmod 777 /var/run/slurmctld

sudo chkconfig ntpd on
sudo ntpdate pool.ntp.org
sudo systemctl start ntpd

#enable slurm daemon
while [ ! -f /scratch/compute.done ]
do
  sleep 5
done
sudo systemctl enable slurmctld
sudo systemctl start slurmctld

sudo touch /scratch/head.done

#wait for callback from metadata
while [ ! -f /scratch/cluster.done ]
do
  sleep 5
done

#restart slurmctld daemon
sudo systemctl restart slurmctld

