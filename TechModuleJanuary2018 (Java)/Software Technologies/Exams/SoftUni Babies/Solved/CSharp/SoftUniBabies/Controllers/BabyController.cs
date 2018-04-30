﻿namespace SoftUniBabies.Controllers
{
    using Models;
    using Microsoft.AspNetCore.Mvc;
    using System.Collections.Generic;
    using System.Linq;

    public class BabyController : Controller
    {
        private readonly BabyDbContext dbContext;

        public BabyController(BabyDbContext dbContext)
        {
            this.dbContext = dbContext;
        }

        [HttpGet]
        [Route("")]
        public IActionResult Index()
        {
            var babies = dbContext.Babies.ToList();

            return View(babies);

        }

        [HttpGet]
        [Route("/create")]
        public IActionResult Create()
        {
            return View();
        }

        [HttpPost]
        [Route("/create")]
        public IActionResult Create(Baby baby)
        {
            if (ModelState.IsValid)
            {
                dbContext.Babies.Add(baby);

                dbContext.SaveChanges();
                return Redirect("/");
            }
            return View();
        }

        [HttpGet]
        [Route("/edit/{id}")]
        public IActionResult Edit(int id)
        {
            var baby = dbContext.Babies.Find(id);

            return View(baby);

        }

        [HttpPost]
        [Route("/edit/{id}")]
        public IActionResult Edit(Baby baby)
        {
            if (ModelState.IsValid)
            {
                dbContext.Babies.Update(baby);
                dbContext.SaveChanges();

                return Redirect("/");
            }

            return View(baby);
        }

        [HttpGet]
        [Route("/delete/{id}")]
        public IActionResult Delete(int id)
        {
            var baby = dbContext.Babies.Find(id);

            return View(baby);
        }

        [HttpPost]
        [Route("/delete/{id}")]
        public IActionResult Delete(Baby baby)
        {
            dbContext.Babies.Remove(baby);
            dbContext.SaveChanges();
            return Redirect("/");
        }
    }
}
