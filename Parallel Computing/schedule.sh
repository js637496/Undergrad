#!/bin/bash

mpicc pi_mc.c -lm

sbatch -N 2 mpirun --allow-run-as-root --np 2 --hostfile machine_list /scratch/a.out 1000000000
sbatch -N 4 mpirun --allow-run-as-root --np 4 --hostfile machine_list /scratch/a.out 1000000000
sbatch -N 6 mpirun --allow-run-as-root --np 6 --hostfile machine_list /scratch/a.out 1000000000
sbatch -N 8 mpirun --allow-run-as-root --np 8 --hostfile machine_list /scratch/a.out 1000000000
sbatch -N 10 mpirun --allow-run-as-root --np 10 --hostfile machine_list /scratch/a.out 1000000000
sbatch -N 12 mpirun --allow-run-as-root --np 12 --hostfile machine_list /scratch/a.out 1000000000
